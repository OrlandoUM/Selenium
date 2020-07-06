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

public class DuplaSena {

    private WebDriver navegador;
    private String Dupla = "https://g1.globo.com/loterias/duplasena.ghtml#1142";
    //private String Dupla = "https://g1.globo.com/loterias/duplasena.ghtml#2032"; //TESTE

    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet("DuplaSena");
    
    public DuplaSena() {
    	Row row = sheet.createRow(0);
        Cell cell2 = row.createCell(0);
        cell2.setCellValue("Sorteio");

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
        
        cell2=row.createCell(8);
        cell2.setCellValue("Sorteado6");
    }

    @Before
    public void todo() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\orlan\\drivers\\chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--whitelist-ip 192.168.0.26");
        chromeOptions.addArguments("--proxy-server='direct://'");
        chromeOptions.addArguments("--proxy-bypass-list=*");
        navegador = new ChromeDriver();
        //navegador.manage().window().maximize();
        navegador.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS); //quero esperar 5 segundos até que meus elementos tenham ações

        navegador.get(Dupla);
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
            
            Row row = sheet.createRow(linha);
            Cell cell2 = row.createCell(0);
            cell2.setCellValue("1");

            cell2=row.createCell(1);
            cell2.setCellValue(concurso);
            
            cell2=row.createCell(2);
            cell2.setCellValue(date);
            
            
            Row row2 = sheet.createRow(linha+1);
        	Cell cell3 = row2.createCell(0);
        	cell3.setCellValue("2");
        	
        	cell3=row2.createCell(1);
            cell3.setCellValue(concurso);
            
            cell3=row2.createCell(2);
            cell3.setCellValue(date);
        	
            for (int i = 1; i <= 12; i++) {
            	
            	WebElement valores = navegador.findElement(By.xpath("(//div[@class='content-lottery__result content-lottery__result--duplasena'])[" + i + "]"));
                s = valores.getText();
            	
            	if (i < 7){
            		if (coluna == 3) System.out.println("1º Sorteio:");
            		
                    cell2 = row.createCell(coluna);
                    cell2.setCellValue(s);
                    
                    coluna++;
                    
                    if(coluna == 9) coluna = 3;
                    
                }
                else{
                    if (coluna == 3) System.out.println("2º Sorteio:");
                    
                    cell3 = row2.createCell(coluna);
                    cell3.setCellValue(s);
                    
                    coluna++;
                    
                    if(coluna == 9) coluna = 3;
                    
                }
                
                System.out.println(s);
                
            }
            System.out.print("\n");
            linha = linha + 2;
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
        
        Row row = sheet.createRow(linha);
        Cell cell2 = row.createCell(0);
        cell2.setCellValue("1");

        cell2=row.createCell(1);
        cell2.setCellValue(concurso);
        
        cell2=row.createCell(2);
        cell2.setCellValue(date);
        
        
        Row row2 = sheet.createRow(linha+1);
    	Cell cell3 = row2.createCell(0);
    	cell3.setCellValue("2");
    	
    	cell3=row2.createCell(1);
        cell3.setCellValue(concurso);
        
        cell3=row2.createCell(2);
        cell3.setCellValue(date);
    	
        for (int i = 1; i <= 12; i++) {
        	
        	WebElement valores = navegador.findElement(By.xpath("(//div[@class='content-lottery__result content-lottery__result--duplasena'])[" + i + "]"));
            s = valores.getText();
        	
        	if (i < 7){
        		if (i == 1) System.out.println("1º Sorteio:");
        		
                cell2 = row.createCell(coluna);
                cell2.setCellValue(s);
                
                coluna++;
                
                if(coluna == 9) coluna = 3;              
                
            }
            else{
                if (i == 7) System.out.println("2º Sorteio:");
                
                cell3 = row2.createCell(coluna);
                cell3.setCellValue(s);
                
                coluna++;
                
                if(coluna == 9) coluna = 3;
                
            }
            
            System.out.println(s);
            
        }
        
    }

    @After
    public void done (){
        navegador.close();
    	try {
            FileOutputStream output = new FileOutputStream("DuplaSena.xls");
            workbook.write(output);
            output.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
