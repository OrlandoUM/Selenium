package teste;

/*
 * 
 * OK
 * 
 * */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.chrome.ChromeOptions;

public class Federal {

    private WebDriver navegador;
    private String Federal = "https://g1.globo.com/loterias/federal.ghtml#4678";
    //private String Federal = "https://g1.globo.com/loterias/federal.ghtml#5372"; //TESTE

    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet("Federal");
    
    public Federal() {
    	Row row = sheet.createRow(0);
        Cell cell2 = row.createCell(0);
        cell2.setCellValue("Bilhete");

        cell2=row.createCell(1);
        cell2.setCellValue("Concurso");

        cell2=row.createCell(2);
        cell2.setCellValue("Data");

        cell2=row.createCell(3);
        cell2.setCellValue("Sorteado1");

        cell2=row.createCell(4);
        cell2.setCellValue("Sorteado2");

        cell2=row.createCell(5);
        cell2.setCellValue("Sorteado3");

        cell2=row.createCell(6);
        cell2.setCellValue("Sorteado4");

        cell2=row.createCell(7);
        cell2.setCellValue("Sorteado5");
        
    }

    @Before
    public void todo() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\orlan\\drivers\\chromedriver.exe"); //para usar o chrome driver
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--whitelist-ip 192.168.0.26");
        chromeOptions.addArguments("--proxy-server='direct://'");
        chromeOptions.addArguments("--proxy-bypass-list=*");
        navegador = new ChromeDriver();
        //navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS); //quero esperar 5 segundos até que meus elementos tenham ações

        navegador.get(Federal);
    }

    @Test
    public void doing () throws InterruptedException {
        String c, c2, s;
        int linha = 1;
        int coluna = 3;
        String concurso;
        String date;
        WebElement check = navegador.findElement(By.xpath("(//a[@role='button'])[2]"));
        c = check.getAttribute("class");

        do {
            WebElement data = navegador.findElement(By.className("content-lottery__info"));
            s = data.getText();
            System.out.println(s);
            concurso = s.substring(9, 13);
            date = s.substring(16, 26);
            
            /*------------1º Bilhete-----------*/
            Row row1 = sheet.createRow(linha);
            Cell cell1 = row1.createCell(0);
            cell1.setCellValue("1");

            cell1=row1.createCell(1);
            cell1.setCellValue(concurso);
            
            cell1=row1.createCell(2);
            cell1.setCellValue(date);
            
            /*------------2º Bilhete-----------*/
            Row row2 = sheet.createRow(linha+1);
        	Cell cell2 = row2.createCell(0);
        	cell2.setCellValue("2");
        	
        	cell2=row2.createCell(1);
            cell2.setCellValue(concurso);
            
            cell2=row2.createCell(2);
            cell2.setCellValue(date);
            
            /*------------3º Bilhete-----------*/
            Row row3 = sheet.createRow(linha+2);
        	Cell cell3 = row3.createCell(0);
        	cell3.setCellValue("3");
        	
        	cell3=row3.createCell(1);
            cell3.setCellValue(concurso);
            
            cell3=row3.createCell(2);
            cell3.setCellValue(date);
            
            /*------------4º Bilhete-----------*/
            Row row4 = sheet.createRow(linha+3);
        	Cell cell4 = row4.createCell(0);
        	cell4.setCellValue("4");
        	
        	cell4=row4.createCell(1);
            cell4.setCellValue(concurso);
            
            cell4=row4.createCell(2);
            cell4.setCellValue(date);
            
            /*------------5º Bilhete-----------*/
            Row row5 = sheet.createRow(linha+4);
        	Cell cell5 = row5.createCell(0);
        	cell5.setCellValue("5");
        	
        	cell5=row5.createCell(1);
            cell5.setCellValue(concurso);
            
            cell5=row5.createCell(2);
            cell5.setCellValue(date);
        	
            
            for (int i = 1; i <= 25; i++) {
            	
            	WebElement valores = navegador.findElement(By.xpath("(//div[@class='content-lottery__result content-lottery__result content-lottery__result--federal'])[" + i + "]"));
                s = valores.getText();
            	
            	if (i <= 5){ //1º Bilhete
            		if (coluna == 3) System.out.println("1º Bilhete:");
            		
                    cell1 = row1.createCell(coluna);
                    cell1.setCellValue(s);
                    
                    coluna++;
                    
                    if(coluna == 8) coluna = 3;
                    
                }
                else if(i <= 10){
                    if (coluna == 3) System.out.println("2º Bilhete:");
                    
                    cell2 = row2.createCell(coluna);
                    cell2.setCellValue(s);
                    
                    coluna++;
                    
                    if(coluna == 8) coluna = 3;
                    
                }
                else if(i <= 15){
                    if (coluna == 3) System.out.println("3º Bilhete:");
                    
                    cell3 = row3.createCell(coluna);
                    cell3.setCellValue(s);
                    
                    coluna++;
                    
                    if(coluna == 8) coluna = 3;
                    
                }
                else if(i <= 20){
                    if (coluna == 3) System.out.println("4º Bilhete:");
                    
                    cell4 = row4.createCell(coluna);
                    cell4.setCellValue(s);
                    
                    coluna++;
                    
                    if(coluna == 8) coluna = 3;
                    
                }
                else if(i <= 25){
                    if (coluna == 3) System.out.println("5º Bilhete:");
                    
                    cell5 = row5.createCell(coluna);
                    cell5.setCellValue(s);
                    
                    coluna++;
                    
                    if(coluna == 8) coluna = 3;
                    
                }
                
                System.out.println(s);
                
            }
            System.out.print("\n");
            linha = linha + 5;
            WebElement button = navegador.findElement(By.xpath("(//span[@class='icon-wrapper'])[2]"));
            button.click();
            WebElement check2 = navegador.findElement(By.xpath("(//a[@role='button'])[2]"));
            c2 = check2.getAttribute("class");
        } while (c.equals(c2));
        
        //última página
        WebElement data = navegador.findElement(By.className("content-lottery__info"));
        s = data.getText();
        System.out.println(s);
        concurso = s.substring(9, 13);
        date = s.substring(16, 26);
        
        /*------------1º Bilhete-----------*/
        Row row1 = sheet.createRow(linha);
        Cell cell1 = row1.createCell(0);
        cell1.setCellValue("1");

        cell1=row1.createCell(1);
        cell1.setCellValue(concurso);
        
        cell1=row1.createCell(2);
        cell1.setCellValue(date);
        
        /*------------2º Bilhete-----------*/
        Row row2 = sheet.createRow(linha+1);
    	Cell cell2 = row2.createCell(0);
    	cell2.setCellValue("2");
    	
    	cell2=row2.createCell(1);
        cell2.setCellValue(concurso);
        
        cell2=row2.createCell(2);
        cell2.setCellValue(date);
        
        /*------------3º Bilhete-----------*/
        Row row3 = sheet.createRow(linha+2);
    	Cell cell3 = row3.createCell(0);
    	cell3.setCellValue("3");
    	
    	cell3=row3.createCell(1);
        cell3.setCellValue(concurso);
        
        cell3=row3.createCell(2);
        cell3.setCellValue(date);
        
        /*------------4º Bilhete-----------*/
        Row row4 = sheet.createRow(linha+3);
    	Cell cell4 = row4.createCell(0);
    	cell4.setCellValue("4");
    	
    	cell4=row4.createCell(1);
        cell4.setCellValue(concurso);
        
        cell4=row4.createCell(2);
        cell4.setCellValue(date);
        
        /*------------5º Bilhete-----------*/
        Row row5 = sheet.createRow(linha+4);
    	Cell cell5 = row5.createCell(0);
    	cell5.setCellValue("5");
    	
    	cell5=row5.createCell(1);
        cell5.setCellValue(concurso);
        
        cell5=row5.createCell(2);
        cell5.setCellValue(date);
    	
        
        for (int i = 1; i <= 25; i++) {
        	
        	WebElement valores = navegador.findElement(By.xpath("(//div[@class='content-lottery__result content-lottery__result content-lottery__result--federal'])[" + i + "]"));
            s = valores.getText();
        	
        	if (i <= 5){
        		if (coluna == 3) System.out.println("1º Bilhete:");
        		
                cell1 = row1.createCell(coluna);
                cell1.setCellValue(s);
                
                coluna++;
                
                if(coluna == 8) coluna = 3;
                
            }
            else if(i <= 10){
                if (coluna == 3) System.out.println("2º Bilhete:");
                
                cell2 = row2.createCell(coluna);
                cell2.setCellValue(s);
                
                coluna++;
                
                if(coluna == 8) coluna = 3;
                
            }
            else if(i <= 15){
                if (coluna == 3) System.out.println("3º Bilhete:");
                
                cell3 = row3.createCell(coluna);
                cell3.setCellValue(s);
                
                coluna++;
                
                if(coluna == 8) coluna = 3;
                
            }
            else if(i <= 20){
                if (coluna == 3) System.out.println("4º Bilhete:");
                
                cell4 = row4.createCell(coluna);
                cell4.setCellValue(s);
                
                coluna++;
                
                if(coluna == 8) coluna = 3;
                
            }
            else if(i <= 25){
                if (coluna == 3) System.out.println("5º Bilhete:");
                
                cell5 = row5.createCell(coluna);
                cell5.setCellValue(s);
                
                coluna++;
                
                if(coluna == 8) coluna = 3;
                
            }
            
            System.out.println(s);
            
        }
        
        
    }

    @After
    public void done (){
        navegador.close();
    	try {
            FileOutputStream output = new FileOutputStream("Federal.xls");
            workbook.write(output);
            output.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
