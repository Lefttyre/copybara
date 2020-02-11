/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.copybara.util;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.copybara.exception.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RepositoryUtilTest {

  @Test
  public void testGoodUrl() throws Exception {
    RepositoryUtil.validateNotHttp("https://copybara.com");
  }

  @Test
  public void testBadUrl() {
    ValidationException expected =
        assertThrows(
            ValidationException.class, () -> RepositoryUtil.validateNotHttp("http://copybara.com"));
    assertThat(expected)
        .hasMessageThat()
        .contains("URL 'http://copybara.com' is not valid - should be using https");
  }
}
