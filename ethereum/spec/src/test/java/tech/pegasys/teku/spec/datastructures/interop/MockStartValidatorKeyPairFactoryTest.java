/*
 * Copyright Consensys Software Inc., 2025
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.spec.datastructures.interop;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import org.apache.tuweni.bytes.Bytes;
import org.junit.jupiter.api.Test;
import tech.pegasys.teku.bls.BLSKeyPair;

class MockStartValidatorKeyPairFactoryTest {
  private static final String[] EXPECTED_PRIVATE_KEYS = {
    "16808672146709759238327133555736750089977066230599028589193936481731504400486",
    "37006103240406073079686739739280712467525465637222501547219594975923976982528",
    "22330876536127119444572216874798222843352868708084730796787004036811744442455",
    "17048462031355941381150076874414096388968985457797372268770826099852902060945",
    "28647806952216650698330424381872693846361470773871570637461872359310549743691",
    "2416304019107052589452838695606585506736351107897780798170812672519914514344",
    "7300215445567548136411883691093515822872548648751398235557229381530420545683",
    "26495790445032093722332687600112008700915252495659977774957922313678954054133",
    "2908643403277969554503670470854573663206729491025062456164283925661321952518",
    "19554639423851580804889717218680781396599791537051606512605582393920758869044"
  };

  private static final String[] EXPECTED_PUBLIC_KEYS = { // Base64 encoded
    "qZp27XeW974i1bfoXe63xWd+iOUR4LM3YY+MTrYTSbS/LRU/ZJ97UzWf6LlKOORM",
    "uJvrxpl2lyajGMjplxvTFxKXxhrqSmV4p6T5S1R9y6W6wWqJEItrah/jaV0ah0oL",
    "o6MrD4tN24PxoKhT2B3XJd/ld9T0w9uOzlLOKwJuyoSBXBp+jpKk3j11VzO/fkqb",
    "iMFB33fNnY16cadcgmxBqcnwPG7hsYDz54UvaigAmd7TUbWNZuZTr45CgWpNj1Mu",
    "gSg7eiDhykYOvZu9dwBdVXNwyrsfmkT1MMTExmIw9nX434tMKBiFGqfXeoDKWkpe",
    "qwvdoPhfhC9DG+rM8SUL8f17pRtBAP1kNktkAf2oW7AGmz5xW1iBloTn/AsQpyo0",
    "mXfxyLcxqNVVgUa/uGyuomQ088WHi1ib8oCkLJFZ5wDp3w5AhilsILAR0ueMJ9Nz",
    "qNTHwneVpyWWExfvWVOnAy7W2Dc524sOinI1PRuLRDlCf376LInKoDzJ8o+Muris",
    "ptMQ27+rmiJFD1mZP4ekzl22Ij87Xx8w0sTscYki1ADgs8d0HejlmWD3JBGg7hCn",
    "mJNBPAAoOj+e2f2YRd2hzqOCKNIlZ/lUHczDV+VKLWpuIEEDySVky8BfSQWsfEk6"
  };

  private final MockStartValidatorKeyPairFactory factory = new MockStartValidatorKeyPairFactory();

  @Test
  public void shouldGenerateValidKeys() {
    final List<BLSKeyPair> keyPairs = factory.generateKeyPairs(0, 10);
    final List<BigInteger> actualPrivateKeys =
        keyPairs.stream()
            .map(keyPair -> keyPair.getSecretKey().toBytes().toBigInteger())
            .collect(toList());

    final List<BigInteger> expectedPrivateKeys =
        Arrays.stream(EXPECTED_PRIVATE_KEYS).map(BigInteger::new).collect(toList());
    assertEquals(expectedPrivateKeys, actualPrivateKeys);

    final List<String> actualPublicKeys =
        keyPairs.stream()
            .map(keyPair -> keyPair.getPublicKey().toSSZBytes().toHexString())
            .collect(toList());

    final List<String> expectedPublicKeys =
        Arrays.stream(EXPECTED_PUBLIC_KEYS)
            .map(base64 -> Bytes.wrap(Base64.getDecoder().decode(base64)).toHexString())
            .collect(toList());
    assertEquals(expectedPublicKeys, actualPublicKeys);
  }
}
