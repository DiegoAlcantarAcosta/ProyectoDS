/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import DAOS.ContactoDAO;
import DAOS.GrupoDAO;
import DTOs.ContactoDTO;
import DTOs.GrupoDTO;
import DTOs.MiembroGrupoDTO;
import Objetos.Interfaces.IObjetoNegocioGrupo;
import com.mongodb.client.MongoDatabase;
import entidades.Contacto;
import entidades.Grupo;
import interfaces.daos.IContactoDAO;
import interfaces.daos.IGrupoDAO;
import org.bson.types.ObjectId;
import interfaces.daos.IGrupoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Oley
 */
public class ObjetoNegocioGrupo implements IObjetoNegocioGrupo {

    
    private IGrupoDAO grupoDAO;
    private IContactoDAO contactoDAO;

    public ObjetoNegocioGrupo() {
        this.grupoDAO =  new GrupoDAO();
        this.contactoDAO = new ContactoDAO();
    }

  


    public Grupo convertirDTOAEntidad(GrupoDTO grupoDTO) {
        Grupo grupo = new Grupo(grupoDTO.getNombre(), grupoDTO.getSaldo(), grupoDTO.getMotivo());

        if (grupoDTO.getContactos() != null) {
            List<Contacto> contactos = new ArrayList<>();
            for (ContactoDTO contactoDTO : grupoDTO.getContactos()) {
                Contacto contacto = new Contacto();
                contacto.setNombre(contactoDTO.getNombre());
                contacto.setApellidoP(contactoDTO.getApellidoP());
                contacto.setApellidoM(contactoDTO.getApellidoM());
                contactos.add(contacto);
            }
            grupo.setContactos(contactos);
        }

        return grupo;
    }

    public GrupoDTO convertirEntidadADTO(Grupo grupo) {
        if (grupo != null) {
            GrupoDTO grupoDTO = new GrupoDTO();
            grupoDTO.setNombre(grupo.getNombre());
            grupoDTO.setSaldo(grupo.getMontoTotal());
            grupoDTO.setMotivo(grupo.getMotivo());

            List<ContactoDTO> contactosDTO = new ArrayList<>();
            for (Contacto contacto : grupo.getContactos()) {
                ContactoDTO contactoDTO = new ContactoDTO();
                contactoDTO.setNombre(contacto.getNombre());
                contactoDTO.setApellidoP(contacto.getApellidoP());
                contactoDTO.setApellidoM(contacto.getApellidoM());
                contactosDTO.add(contactoDTO);
            }
            grupoDTO.setContactos(contactosDTO);

            return grupoDTO;
        } else {
            return null;
        }
    }

    @Override
    public ObjectId crearGrupo(GrupoDTO grupoDTO) {
     // Verificar si grupoDAO es nulo
   
    
    // Convertir el DTO a una entidad Grupo
    Grupo grupo = convertirDTOAEntidad(grupoDTO);
    
    // Llamar al método crearGrupo en grupoDAO para guardar el grupo en la base de datos
    grupoDAO.crearGrupo(grupo);
    
    // Suponiendo que crearGrupo devuelve el ObjectId del grupo creado, puedes devolverlo
    return grupo.getId();
    }

    @Override
    public GrupoDTO obtenerGrupoPorId(String id) {
        ObjectId objectId = new ObjectId(id);
        Grupo grupo = grupoDAO.obtenerGrupoPorID(objectId);
        GrupoDTO grupoDTO = convertirEntidadADTO(grupo);
        return grupoDTO;
    }

    private Contacto convertirDTOAEntidadContacto(ContactoDTO contactoDTO) {
        Contacto contacto = new Contacto();
        contacto.setNombre(contactoDTO.getNombre());
        contacto.setApellidoP(contactoDTO.getApellidoP());
        contacto.setApellidoM(contactoDTO.getApellidoM());
        return contacto;
    }

  public Boolean agregarContacto(ContactoDTO contactoDTO, String idGrupo) {
    try {
        // Verificar si grupoDAO es nulo
        if (grupoDAO == null) {
            throw new IllegalStateException("IGrupoDAO no ha sido inicializado");
        }
        
        // Convertir el ContactoDTO a un Contacto
        Contacto contacto = convertirDTOAEntidadContacto(contactoDTO);
        
        // Llamar al método correspondiente en tu lógica de negocio para agregar el contacto al grupo
        Boolean agregado = grupoDAO.agregarContacto(contacto, idGrupo);
        
        return agregado;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    }

    }

}
