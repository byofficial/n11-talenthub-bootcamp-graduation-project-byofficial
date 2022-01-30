package com.n11.graduationproject.service.impl;

import com.n11.graduationproject.service.IFakeNationalIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.Vector;

@Service
@Slf4j
public class FakeNationalIdGenerator implements IFakeNationalIdGenerator {

    private final String CLASS_NAME_LOG = this.getClass().getSimpleName();

    /**
     * Generate Valid National Identity Number
     *
     * @return Returns a valid and random 11-character National Identity Number
     */
    @Override
    public String generateNationalIdNumber() {
        log.info(CLASS_NAME_LOG + " service generateNationalIdNumber method is running.");

        Vector<Integer> array = new Vector<Integer>();
        Random randomGenerator = new Random();

        array.add(new Integer(1 + randomGenerator.nextInt(9)));

        for (int i = 1; i < 9; i++) array.add(randomGenerator.nextInt(10));

        int t1 = 0;
        for (int i = 0; i < 9; i += 2) t1 += array.elementAt(i);

        int t2 = 0;
        for (int i = 1; i < 8; i += 2) t2 += array.elementAt(i);

        int x = (t1 * 7 - t2) % 10;

        array.add(new Integer(x));

        x = 0;
        for (int i = 0; i < 10; i++) x += array.elementAt(i);

        x = x % 10;
        array.add(new Integer(x));

        String nationalId = "";
        for (int i = 0; i < 11; i++) {
            nationalId = nationalId + array.elementAt(i);
        }

        log.info("Generated national identity number! " + nationalId);
        return nationalId;
    }
}
