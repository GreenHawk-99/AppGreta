package com.cda.contenu_seance.services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
public class ImportExcelService {

    public void generateDataFromExcel(InputStream file) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
        XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

        FormulaEvaluator formulaEvaluator = xssfWorkbook.getCreationHelper().createFormulaEvaluator();
        int a = 0;
        int c = 0;
        int s = 0;
        for (Row line : xssfSheet){
            Cell cell = line.getCell(0);
            if (cell != null && cell.getCellType() == CellType.STRING){
                if (cell.getStringCellValue().contains("SUIVI PEDAGOGIQUE DE LA FORMATION")){
                    String[] tabFormations = cell.getStringCellValue().split(" : ");
                    String nomForma = tabFormations[1];
                    System.out.println("Formation: "+nomForma);
                }
                if (cell.getStringCellValue().contains("Dates :")){
                    String[] tabDates1 = cell.getStringCellValue().split(" : ");
                    String[] tabDates2 = tabDates1[1].split(" AU ");
                    //System.out.println("Date de la session: "+tabDates2[0]+" - "+tabDates2[1]);
                    String dateDebut = tabDates2[0];
                    String dateFin = tabDates2[1];
                    System.out.println("Date de la session: "+dateDebut+" - "+dateFin);
                }
                if (cell.getStringCellValue().contains("Centre de formation :")){
                    String[] tabCentre = cell.getStringCellValue().split(" : ");
                    String nomCentre = tabCentre[1];
                    System.out.println("Centre: "+nomCentre);
                }
                // fin entête debut ccp comp
                if (cell.getStringCellValue().contains("CCP")){
                    a++;
                    String[] tabActivites = cell.getStringCellValue().split(" : ");
                    String activite = tabActivites[1];

                    System.out.println("Activité " + a +" : "+ activite);
                    System.out.println("-_--_--_--_--_--_--_--_--_--_--_--_--_--_--_-");
                }else if (cell.getStringCellValue().contains("COMPETENCE")) {
                    String[] tabCompetences = cell.getStringCellValue().split(" : ");
                    String[] tabSkills = tabCompetences[1].split("- ");
                    s++;
                    String competence = tabSkills[0];
                    String skill = tabSkills[1];

                    System.out.println("Compétence " + c + " : " + competence);
                    System.out.println("Skills " + s + " : " + skill);
                    System.out.println("--------------------------");
                }
            }
        }
        System.out.println("Nombre d'activités' : "+a);
        //System.out.println("Nombre de compétences' : "+c);
        System.out.println("Nombre de skills' : "+s);
    }
}
