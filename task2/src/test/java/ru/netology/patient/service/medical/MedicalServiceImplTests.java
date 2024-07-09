package ru.netology.patient.service.medical;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.patient.entity.BloodPressure;
import ru.netology.patient.service.alert.SendAlertService;
import ru.netology.patient.service.alert.SendAlertServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;

public class MedicalServiceImplTests {


    @Test
    public void testcheckBloodPressure() {

        // given:
        String expected = "Warning, patient with id: 1, need help\r\n";
        String consoleOutput = null;
        PrintStream originalOutput = System.out;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
             PrintStream capture = new PrintStream(baos)) {
            System.setOut(capture);
            PatientInfoFileRepositoryMock patient = new PatientInfoFileRepositoryMock();
            SendAlertService send = new SendAlertServiceImpl();
            MedicalServiceImpl medicalService = new MedicalServiceImpl(patient, send);
            medicalService.checkBloodPressure("1", new BloodPressure(120, 90));
            capture.flush();
//            System.setOut(originalOutput);


            // when:
            consoleOutput = baos.toString();

            // then:
            Assertions.assertEquals(expected, consoleOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testcheckTemperature() {

        // given:
        String expected = "Warning, patient with id: 1, need help\r\n";
        String consoleOutput = null;
        PrintStream originalOutput = System.out;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
             PrintStream capture = new PrintStream(baos)) {
            System.setOut(capture);
            PatientInfoFileRepositoryMock patient = new PatientInfoFileRepositoryMock();
            SendAlertService send = new SendAlertServiceImpl();
            MedicalServiceImpl medicalService = new MedicalServiceImpl(patient, send);
            medicalService.checkTemperature("1", new BigDecimal("38.65"));
            capture.flush();
            System.setOut(originalOutput);


            // when:
            consoleOutput = baos.toString();

            // then:
            Assertions.assertEquals(expected, consoleOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testcheckBloodPressureNorm() {

        // given:
        String expected = "";
        String consoleOutput = null;
        PrintStream originalOutput = System.out;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
             PrintStream capture = new PrintStream(baos)) {
            System.setOut(capture);
            PatientInfoFileRepositoryMock patient = new PatientInfoFileRepositoryMock();
            SendAlertService send = new SendAlertServiceImpl();
            MedicalServiceImpl medicalService = new MedicalServiceImpl(patient, send);
            medicalService.checkBloodPressure("1", new BloodPressure(120, 80));
            capture.flush();
//            System.setOut(originalOutput);


            // when:
            consoleOutput = baos.toString();

            // then:
            Assertions.assertEquals(expected, consoleOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testcheckTemperatureNorm() {

        // given:
        String expected = "";
        String consoleOutput = null;
        PrintStream originalOutput = System.out;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(100);
             PrintStream capture = new PrintStream(baos)) {
            System.setOut(capture);
            PatientInfoFileRepositoryMock patient = new PatientInfoFileRepositoryMock();
            SendAlertService send = new SendAlertServiceImpl();
            MedicalServiceImpl medicalService = new MedicalServiceImpl(patient, send);
            medicalService.checkTemperature("1", new BigDecimal("37.65"));
            capture.flush();
            System.setOut(originalOutput);


            // when:
            consoleOutput = baos.toString();

            // then:
            Assertions.assertEquals(expected, consoleOutput);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
