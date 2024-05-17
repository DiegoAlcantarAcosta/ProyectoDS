///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Funcionalidad;
//
//import DTOs.MiembroGrupoDTO;
//import entidades.MiembroGrupo;
//import interfaces.daos.IMiembroGrupoDAO;
//import org.bson.types.ObjectId;
//
///**
// *
// * @author Oley
// */
//public class MiembroGrupoSS implements IMiembroGrupoSS{
//    private final IMiembroGrupoDAO miembroGrupoDAO;
//
//    public MiembroGrupoSS(IMiembroGrupoDAO miembroGrupoDAO) {
//        this.miembroGrupoDAO = miembroGrupoDAO;
//    }
//
//
//    @Override
//    public Boolean agregarMiembro(MiembroGrupoDTO miembroDTO, String idGrupo) {
//        try {
//            ObjectId grupoId = new ObjectId(idGrupo);
//            MiembroGrupo miembroGrupo = convertirAMiembroGrupo(miembroDTO);
//            return miembroGrupoDAO.agregarMiembro(miembroGrupo, grupoId);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    private MiembroGrupo convertirAMiembroGrupo(MiembroGrupoDTO miembroDTO) {
//        MiembroGrupo miembroGrupo = new MiembroGrupo();
//        miembroGrupo.setNombre(miembroDTO.getNombre());
//        miembroGrupo.setApellidoP(miembroDTO.getApellidoPaterno());
//        miembroGrupo.setApellidoM(miembroDTO.getApellidoMaterno());
//        return miembroGrupo;
//    }
//}
