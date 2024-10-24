/*
 * Copyright © 2024 Apple Inc. and the Pkl project authors. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.pkl.core

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DataSizeUnitTest {
  @Test
  fun destructure() {
    val bytes = DataSizeUnit.BYTES
    assertThat(bytes.bytes).isEqualTo(1)
    assertThat(bytes.symbol).isEqualTo("b")

    val mebibytes = DataSizeUnit.MEBIBYTES
    assertThat(mebibytes.bytes).isEqualTo(1024L * 1024)
    assertThat(mebibytes.symbol).isEqualTo("mib")
  }

  @Test
  fun `toString()`() {
    assertThat(DataSizeUnit.BYTES.toString()).isEqualTo("b")
    assertThat(DataSizeUnit.MEBIBYTES.toString()).isEqualTo("mib")
  }

  @Test
  fun parse() {
    assertThat(DataSizeUnit.parse("gb")).isEqualTo(DataSizeUnit.GIGABYTES)
    assertThat(DataSizeUnit.parse("other")).isNull()
  }
}
