package com.ubikgs.androidsensors.persistence.repositories;

import com.ubikgs.androidsensors.records.SensorRecord;

import org.junit.After;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Copyright 2017 Alberto González Pérez
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * <p>http://www.apache.org/licenses/LICENSE-2.0</p>
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public abstract class SensorRecordRepositoryIntegrationTest<T extends SensorRecord> {

    protected SensorRecordRepository<T> sensorRecordRepository;

    public void setUp() throws Exception {
        if (sensorRecordRepository == null) {
            throw new Error("You must inject a sensorRecordRepository on setUp method");
        }
    }

    @Test
    public void checkThatStoresAndRetrievesData() throws Exception {
        List<T> sensorRecords = createTestSensorRecords();

        sensorRecordRepository.createAll(sensorRecords).blockingGet();
        List<T> retrievedSensorRecords =
                sensorRecordRepository.findAll().toList().blockingGet();

        assertThat(sensorRecords, equalTo(retrievedSensorRecords));
    }

    @Test
    public void checkThatStoresAndRetrievesDataWithForeignKey() throws Exception {
        List<T> sensorRecords = createTestSensorRecords();

        long foreignKey = 5L;
        sensorRecordRepository.createAll(sensorRecords, foreignKey).blockingGet();
        List<T> retrievedSensorRecords =
                sensorRecordRepository.findAllBy(foreignKey).toList().blockingGet();

        assertThat(sensorRecords, equalTo(retrievedSensorRecords));
    }

    @After
    public void tearDown() throws Exception {
        sensorRecordRepository.removeAll();
    }

    private List<T> createTestSensorRecords() {
        return Arrays.asList(
                createSensorRecord(),
                createSensorRecord()
        );
    }

    protected abstract T createSensorRecord();
}
