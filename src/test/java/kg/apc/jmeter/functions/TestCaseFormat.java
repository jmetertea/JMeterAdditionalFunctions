/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package kg.apc.jmeter.functions;

import static org.junit.Assert.assertEquals;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.threads.JMeterContext;
import org.apache.jmeter.threads.JMeterContextService;
import org.apache.jmeter.threads.JMeterVariables;
import org.junit.*;

import java.util.Collection;
import java.util.LinkedList;
/**
 * 
 * Test {@link CaseFormat} Function
 * 
 * @see CaseFormat
 *
 */
public class TestCaseFormat {
	
	private SampleResult result;

    private Collection<CompoundVariable> params;

    private JMeterVariables vars;

    private JMeterContext jmctx;

	private CaseFormat changeCase;

    @Before
    public void setUp() {
    	changeCase = new CaseFormat();
        result = new SampleResult();
        jmctx = JMeterContextService.getContext();
        String data = "dummy data";
        result.setResponseData(data, null);
        vars = new JMeterVariables();
        jmctx.setVariables(vars);
        jmctx.setPreviousResult(result);
        params = new LinkedList<>();
    }

    @Test
    public void testLowerCaseNonEnglish() throws Exception {
    	params.add(new CompoundVariable("ab-àÀè_È é É ù Ù ì Ì ò Ò ñ ÑäöüßCD   eF"));
    	params.add(new CompoundVariable("LOWER_CAMEL_CASE"));
    	changeCase.setParameters(params);
    	changeCase.setParameters(params);
    	String returnValue = changeCase.execute(result, null);
    	assertEquals("abÀàèÈÉÉÙÙÌÌÒÒÑÑäöüßcdEf", returnValue);
    }
    
    @Test
    public void testUpperCaseNonEnglish() throws Exception {
    	params.add(new CompoundVariable("ab-àÀè_È é É ù Ù ì Ì ò Ò ñ ÑäöüßCD   eF"));
    	params.add(new CompoundVariable("UPPER_CAMEL_CASE"));
    	changeCase.setParameters(params);
    	changeCase.setParameters(params);
    	String returnValue = changeCase.execute(result, null);
    	assertEquals("AbÀàèÈÉÉÙÙÌÌÒÒÑÑäöüßcdEf", returnValue);
    }
    
    @Test
    public void testChangeCaseKebabCase() throws Exception {
    	params.add(new CompoundVariable("ab-àÀè_È é É ù Ù ì Ì ò Ò ñ ÑäöüßCD   eF"));
    	params.add(new CompoundVariable("KEBAB_CASE"));
    	changeCase.setParameters(params);
    	changeCase.setParameters(params);
    	String returnValue = changeCase.execute(result, null);
    	assertEquals("ab-ààè-è-é-é-ù-ù-ì-ì-ò-ò-ñ-ñäöüßcd-ef", returnValue);
    }
    
	@Test
    public void testChangeCaseTrainCase() throws Exception {
    	params.add(new CompoundVariable("ab-àÀè_È é É ù Ù ì Ì ò Ò ñ ÑäöüßCD   eF"));
    	params.add(new CompoundVariable("TRAIN_CASE"));
    	changeCase.setParameters(params);
    	changeCase.setParameters(params);
    	String returnValue = changeCase.execute(result, null);
    	assertEquals("AB-ÀÀÈ-È-É-É-Ù-Ù-Ì-Ì-Ò-Ò-Ñ-ÑÄÖÜSSCD-EF", returnValue);
    }
}
