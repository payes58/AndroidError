package com.example.bolsaborrador;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {

        //CREATE

        bd.execSQL("CREATE TABLE Genders(idGender int PRIMARY KEY AUTOINCREMENT,Gender varchar(800));");

        bd.execSQL("CREATE TABLE States(idState int PRIMARY KEY AUTOINCREMENT,States varchar(800));");

        bd.execSQL("CREATE TABLE Rols(idRol int PRIMARY KEY AUTOINCREMENT, Rol varchar(800));");

        bd.execSQL("CREATE TABLE Departments(idDepartment int PRIMARY KEY AUTOINCREMENT,Department varchar(800));");

        bd.execSQL("CREATE TABLE workSubjects(idSubject int PRIMARY KEY AUTOINCREMENT,WorkSubject varchar(800));");

        bd.execSQL("CREATE TABLE Levels(idLevel int PRIMARY KEY AUTOINCREMENT, Levels varchar(800))");

        bd.execSQL("CREATE TABLE Branches (idBranch int PRIMARY KEY AUTOINCREMENT, Branch varchar(800), idLevel int, idPostulante int, FOREIGN KEY(idLevel) REFERENCES Levels(idLevel), FOREIGN KEY(idPostulant) REFERENCES Postulants(idPostulant))");

        bd.execSQL("CREATE TABLE AditionalSkills(idAskills int PRIMARY KEY AUTOINCREMENT, NameSkill varchar(800), idLevel int, idPostulante int, FOREIGN KEY(idLevel) REFERENCES Levels(idLevel), FOREIGN KEY (idPostulant) REFERENCES Postulants(idPostulant))");

        bd.execSQL("CREATE TABLE StudyLevels(idSLevel int PRIMARY KEY AUTOINCREMENT, studylevel varchar(800))");

        bd.execSQL("CREATE TABLE ContractType(idContactT int PRIMARY KEY AUTOINCREMENT, studyLevel varchar(800))");

        bd.execSQL("CREATE TABLE WorkState(idWorkState int PRIMARY KEY AUTOINCREMENT, WorkState varchar(800))");

        bd.execSQL("CREATE TABLE HighType(idType int PRIMARY KEY AUTOINCREMENT, HighRType varchar(800))");

        bd.execSQL("CREATE TABLE SalaryState(idSalary int PRIMARY KEY AUTOINCREMENT, Salary varchar(800))");

        bd.execSQL("CREATE TABLE Postulants(idPostulant int PRIMARY KEY AUTOINCREMENT, namePostulant varchar(800), mailPostulant varchar(800), Pword varchar(20000), photoPostulant varchar(800), resumePDF varchar(20000), resumeDetails varchar(800), mailverification BIT, Gender int, States int, Alumni BIT, RDepartment int, IDepartment int, WSubjet int, Progress int, Salary int, HighType int, ContractType int, WorkPreference int, StudyLevel int, WorkStatus int, FOREIGN KEY(StudyLevel) REFERENCES StudyLevels(idSLevel), FOREIGN KEY(WorkPreference) REFERENCES WorkPreference(idPreference), FOREIGN KEY(WorkStatus) REFERENCES WorkState(idWorkSatet), foreign key(ContractType) REFERENCES ContractType(idContractT), FOREIGN KEY(HighType) REFERENCES HighType(idType), foreign key(Salary) REFERENCES Salary (idSalary), FOREIGN KEY(Gender) REFERENCES Genders(idGender), FOREIGN KEY(WSubject) REFERENCES workSubjects(idSubject), foreign key(Progress) REFERENCES Progress(idProgress), FOREIGN KEY(RDepartment) REFERENCES Departments(idDepartment), FOREIGN KEY (IDepartment) REFERENCES Departments(idDepartment))");

        bd.execSQL("CREATE TABLE Moderatios(idMod int PRIMARY KEY AUTOINCREMENT, idPostulant int, idUserSystem int, dateMod DATE, context varchar(20000), request varchar(20000), requestedInfo varchar(20000), FOREIGN KEY(idPostulant) REFERENCES Postulants(idPostulant), FOREIGN KEY(idUserSystem) REFERENCES UserSystems(idUser))");

        bd.execSQL("CREATE TABLE UserSystems(idUser int PRIMARY KEY AUTOINCREMENT, idState int, nameUser varchar(50), Pword varchar(250), mailUser varchar(45), numberUser numeric(8), idRol int, mailverification BIT, idGender int, FOREIGN KEY(idrol) REFERENCES Rols(idRol), FOREIGN KEY(idState) REFERENCES States(idState), FOREIGN KEY(idGender) REFERENCES Genders(idGender))");

        bd.execSQL("CREATE TABLE GeneralSkills(idGskill int PRIMARY KEY AUTOINCREMENT, Skill varchar(20000), idLevel int, idPostulant int, FOREIGN KEY(idLevel) REFERENCES Levels(idLevel), FOREIGN KEY(idPostulant) REFERENCES Postulants(idPostulant))");

        //INSERTS

        bd.execSQL("INSERT INTO Departments(Department) VALUES ('Ahuachapan'), ('Santa Ana'),('Sonsonate'),('Chalatenango'),('La Libertad'),('San Salvador'),('Cuscatlán'),('Cabañas'),('San Vicente'),('La Paz'),('Morazán'),('San Miguel'),('Usulutan'),('La unión');");

        bd.execSQL("INSERT INTO StudyLevels(studylevel) VALUES ('Bachiller'),('Universidad Completa'),('Universidad incompleta'),('Técnico'),('Centro de formación profesional'),('Iniciando Universidad');");

        bd.execSQL("INSERT INTO WorkState(WorkState) VALUES('En busca de empleo'),('Empleado con disponibilidad de cambiar trabajo'),('Trabajo por proyectos'),('Trabajando por horas'),('Trabajo por servicio profesional');");

        bd.execSQL("INSERT INTO HighType(HighType) VALUES ('General'),('Técnico'),('Sin Finalizar');");

        bd.execSQL("INSERT INTO SalaryState(Salary) VALUES ('Mínimo'),('$361 - $500'),('$501 - $750'),('$751 - $1000'), ('$1001 - $1500'), ('Mayo o igual a $1500');");

        bd.execSQL("INSERT INTO WorkPreference(WPreference) VALUES ('Nacional'),('Extranjero'),('Nacional y Extranjero'); ");

        bd.execSQL("INSERT INTO  Rols (Rol) VALUES ('Root'), ('Admin'), ('User');");

        bd.execSQL("INSERT INTO States(States) VALUES ('Disponible'), ('Bloqueado');");

        bd.execSQL("INSERT INTO Genders(Gender) VALUES ('Masculino'), ('Femenino');");

        bd.execSQL("INSERT INTO Progress(Progress) VALUES ('Revisando tu aplicación'),('En espera de CV en pdf'), ('En portal'), ('Información Solicitada'),('Información Enviada'),('Contratado');");

        bd.execSQL("INSERT INTO workSubjects(WorkSubject) VALUES ('ARQUITECTURA'), ('DISEÑO GRAFICO'),('ELECTROMECANICA'),('SISTEMAS INFORMATICOS'),('AERONAUTICO'),('ELECTRONICA'),('HOTELERIA'),('MECÁNICA INDUSTRIAL'),('MANTENIMIENTO AUTOMOTRIZ'),('SISTEMAS ELECTRICOS'),('ADMINISTRATIVO CONTABLE'),('SERVICIOS TURISTICOS'),('DESARROLLO DE SOFTWARE'),('INFRAESTRUCTURA TECNOLÓGICA Y SERVICIOS INFORMÁTICOS'),('CONTADURIA'),('SECRETARIADO'),('ASISTENCIA CONTABLE'),('ASISTENCIA ADMINISTRATIVA'),('MECANICA GENERAL'),('SALUD'),('OTRO');");

        bd.execSQL("INSERT INTO Levels(Levels) VALUES ('Basico'), ('Intermedio'), ('Avanzado'); ");

        bd.execSQL("INSERT INTO ContractType(WType) VALUES ('Temporal'),('Tiempo completo'), ('Por horas'),('Por proyecto'),('Medio tiempo');");

        bd.execSQL("INSERT INTO Postulants(namePostulant,mailPostulant,Pword,photoPostulant,resumePDF,resumeDetails,mailverification,Gender,States,Alumni,RDepartment,IDepartment,WSubject,Progress,Salary,HighType,ContractType,WorkPreference,StudyLevel,WorkStatus,lastName) VALUES ('Jonathan','jonathan.dads@gmail.com','hola123','',0,'',1,2,1,5,4,2,1,1,2,3,3,1,2,2,'Marchelli'),('Paty','pat.dads@gmail.com','hola123','',0,'',1,2,1,5,4,2,1,1,2,3,3,1,2,2,'Garcia'), ('Ramon','rams.dads@gmail.com','noRam123','',0,'',1,2,2,5,6,2,1,1,2,3,3,1,2,1,'Ramirez'); ");

        bd.execSQL("INSERT INTO GeneralSkills(Skill,idLevel,idPostulant) VALUES ('Creador de presentaciones',2,2),('Diseñador de diagramas',1,3),('Cocinar',3,1); ");

        bd.execSQL("INSERT INTO AditionalSkills(NameSkill,idLevel,idPostulant) VALUES ('Limpieza',1,1), ('Concentración permisiva',1,3), ('Cooperativo',2,3);");

        bd.execSQL("INSERT INTO Branches(Branch,idLevel,idPostulant) VALUES ('Ingenieria',2,2), ('Contaduria',1,1),('Mecanica',3,3);");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
