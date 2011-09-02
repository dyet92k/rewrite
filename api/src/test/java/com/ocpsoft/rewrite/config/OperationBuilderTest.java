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

import com.ocpsoft.rewrite.context.EvaluationContext;
import com.ocpsoft.rewrite.event.Rewrite;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
public class OperationBuilderTest
{
   @Test
   public void testChainingOperations()
   {
      MockOperation one = new MockOperation();
      MockOperation two = new MockOperation();
      MockOperation three = new MockOperation();
      MockOperation four = new MockOperation();

      Operation composite = one.and(two).and(three.and(four));

      composite.perform(null, null);

      Assert.assertTrue(one.isPerformed());
      Assert.assertTrue(two.isPerformed());
      Assert.assertTrue(three.isPerformed());
      Assert.assertTrue(four.isPerformed());
   }

   private class MockOperation extends OperationBuilder
   {
      private boolean performed = false;

      @Override
      public void perform(final Rewrite event, final EvaluationContext context)
      {
         this.performed = true;
      }

      public boolean isPerformed()
      {
         return performed;
      }
   }
}