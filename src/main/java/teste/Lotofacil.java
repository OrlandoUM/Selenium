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

public class Lotofacil {
    private WebDriver navegador;
    private String Lotofacil = "https://g1.globo.com/loterias/lotofacil.ghtml#879";
    //private String Lotofacil = "https://g1.globo.com/loterias/lotofacil.ghtml#1791"; //TESTE

    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet("Lotofacil");

    public Lotofacil() {
        
        Row row = sheet.createRow(0);
        Cell cell2 = row.createCell(0);
        cell2.setCellValue("Concurso");

        cell2=row.createCell(1);
        cell2.setCellValue("Data");

        cell2=row.createCell(2);
        cell2.setCellValue("Sorteado1");

        cell2=row.createCell(3);
        cell2.setCellValue("Sorteado2");

        cell2=row.createCell(4);
        cell2.setCellValue("Sorteado3");

        cell2=row.createCell(5);
        cell2.setCellValue("Sorteado4");

        cell2=row.createCell(6);
        cell2.setCellValue("Sorteado5");

        cell2=row.createCell(7);
        cell2.setCellValue("Sorteado6");
        
        cell2=row.createCell(8);
        cell2.setCellValue("Sorteado7");
        
        cell2=row.createCell(9);
        cell2.setCellValue("Sorteado8");
        
        cell2=row.createCell(10);
        cell2.setCellValue("Sorteado9");
        
        cell2=row.createCell(11);
        cell2.setCellValue("Sorteado10");
        
        cell2=row.createCell(12);
        cell2.setCellValue("Sorteado11");
        
        cell2=row.createCell(13);
        cell2.setCellValue("Sorteado12");
        
        cell2=row.createCell(14);
        cell2.setCellValue("Sorteado13");
        
        cell2=row.createCell(15);
        cell2.setCellValue("Sorteado14");
        
        cell2=row.createCell(16);
        cell2.setCellValue("Sorteado15");
        
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

        navegador.get(Lotofacil);
    }

    @Test
    public void doing () throws InterruptedException {
        String c, c2, s;
        int linha = 1;
        WebElement check = navegador.findElement(By.xpath("(//a[@role='button'])[2]"));
        c = check.getAttribute("class");

        do {
            WebElement data = navegador.findElement(By.className("content-lottery__info"));
            s = data.getText();
            System.out.println(s);

            Row row = sheet.createRow(linha);
            Cell cell2 = row.createCell(0);
            cell2.setCellValue(s.substring(9, 13));

            cell2=row.createCell(1);
            cell2.setCellValue(s.substring(16));

            for (int i = 1; i <= 15; i++) {
                WebElement valores = navegador.findElement(By.xpath("(//div[@class='content-lottery__result content-lottery__result--lotofacil'])[" + i + "]"));
                s = valores.getText();

                System.out.println(s);

                cell2=row.createCell((i+1));
                cell2.setCellValue(s);

            }
            System.out.print("\n");
            linha++;

            WebElement button = navegador.findElement(By.xpath("(//span[@class='icon-wrapper'])[2]"));
            button.click();
            WebElement check2 = navegador.findElement(By.xpath("(//a[@role='button'])[2]"));
            c2 = check2.getAttribute("class");
        } while (c.equals(c2));

        //Última página
        WebElement data = navegador.findElement(By.className("content-lottery__info"));
        s = data.getText();
        System.out.println(s);

        Row row = sheet.createRow(linha);
        Cell cell2 = row.createCell(0);
        cell2.setCellValue(s.substring(9, 13));

        cell2=row.createCell(1);
        cell2.setCellValue(s.substring(16));

        for (int i = 1; i <= 15; i++) {
            WebElement valores = navegador.findElement(By.xpath("(//div[@class='content-lottery__result content-lottery__result--lotofacil'])[" + i + "]"));
            s = valores.getText();

            System.out.println(s);

            cell2=row.createCell((i+1));
            cell2.setCellValue(s);

        }
        
    }

    @After
    public void done (){
        navegador.close();

        try {
            FileOutputStream output = new FileOutputStream("Lotofacil.xls");
            workbook.write(output);
            output.close();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
