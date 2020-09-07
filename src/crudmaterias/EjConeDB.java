package crudmaterias;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class EjConeDB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre = "";
        String sexo = "";
//        System.out.println("Escribe el nombre: ");
//        nombre = sc.next();
//        System.out.println("Escribe el sexo: ");
//        sexo = sc.next();
//        char c = sexo.charAt(0);
        Materia mat = new Materia(12377, "Casd", "asd", 18);

        EjConeDB ej = new EjConeDB();
        ej.MySqlConexion("root", "", "des3");
//      ej.createDB("des31");
        //ej.insertData(mat);
        ej.select();
    }

    Connection conexion;

    public void MySqlConexion(String usuario, String pass, String db) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, usuario, pass);
            System.out.println("Se realizo la conexion.");
        } catch (Exception x) {
            System.out.println(x);
        }
    }

    public void closeConnection() {
        try {
            conexion.close();

        } catch (Exception x) {
            System.out.println(x);
        }
    }

    // crea una base de datos
//    public void createDB(String name) {
//        try {
//            String query = "CREATE DATABASE" + name;
//            Statement st = conexion.createStatement();
//            st.execute(query);
//            closeConnection();
//            MySqlConexion("root", "", name);
//            System.out.println("Se ha creado la base de datos " + name + "de forma exitosa");
//        } catch (Exception x) {
//            System.out.println(x);
//        }
//
//    }
    public void insertData(Materia a) {
        try {
            String query = "INSERT INTO materias(clave,nombre,semestre,nocreditos) VALUES(?,?,?,?)";

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, a.getClave());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getSemestre());
            ps.setInt(4, a.getCreditos());
            ps.executeUpdate();
            System.out.println("Se insertaron los datos.");
        } catch (Exception x) {
            System.out.println(x);
        }
    }

    
    public void updateData(Materia a) {
        try {
            String query = "UPDATE materias SET clave=?,nombre=?,semestre=?,nocreditos=? WHERE clave=?";

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, a.getClave());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getSemestre());
            ps.setInt(4, a.getCreditos());
            ps.setInt(5, a.getClave());
            ps.executeUpdate();
            System.out.println("Se actualizaron los datos.");
        } catch (Exception x) {
            System.out.println(x);
        }
    }

    public void deleteData(int clave) {
        try {
            String query = "DELETE FROM materias WHERE clave=?";

            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setInt(1, clave);
            ps.executeUpdate();
            //System.out.println(ps.toString());
            System.out.println("Se actualizaron los datos.");
        } catch (Exception x) {
            System.out.println(x);
        }
    }

    public ArrayList select() {
        ArrayList<Materia> al = new ArrayList<Materia>();
        Materia a;
        try {
            String query = "SELECT * FROM materias ";
            Statement st = conexion.createStatement();
            ResultSet resultset = st.executeQuery(query);
            
            while (resultset.next()) {
                a = new Materia(resultset.getInt("clave"), resultset.getString("nombre"), resultset.getString("semestre"), resultset.getInt("nocreditos"));
                al.add(a);
            }
            
        } catch (Exception x) {
            System.out.println(x);
        }
        return al;

    }

}
