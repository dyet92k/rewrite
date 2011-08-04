/*
 * Copyright 2011 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ocpsoft.rewrite.config;

import org.junit.Assert;
import org.junit.Test;

import com.ocpsoft.rewrite.mock.MockEvaluationContext;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public class NotTest
{
   @Test
   public void testNotFalseIsTrue()
   {
      Condition condition = Not.any(new False());
      Assert.assertTrue(condition.evaluate(new MockRewrite(), new MockEvaluationContext()));
   }

   @Test
   public void testNotTrueIsFalse()
   {
      Condition condition = Not.any(new True());
      Assert.assertFalse(condition.evaluate(new MockRewrite(), new MockEvaluationContext()));
   }
}
