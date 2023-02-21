package com.example.pracproject

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilsTest {

    @Test
    fun `empty username return false`() {
        val result = RegistrationUtils.validationOnRegistration(
            "",
            "9898989898",
            "abc",
            "abc"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty phoneNumber return false`() {
        val result = RegistrationUtils.validationOnRegistration(
            "qwert",
            "",
            "abc",
            "abc"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `empty password return false`() {
        val result = RegistrationUtils.validationOnRegistration(
            "qwert",
            "9898989898",
            "",
            "abc"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `passwords not match return false`() {
        val result = RegistrationUtils.validationOnRegistration(
            "qwert",
            "9898989898",
            "abc",
            "abcd"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `number length less than 10 return false`() {
        val result = RegistrationUtils.validationOnRegistration(
            "qwert",
            "98989898",
            "abc",
            "abc"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `number length greater than 10 return false`() {
        val result = RegistrationUtils.validationOnRegistration(
            "qwert",
            "98989898",
            "abc",
            "abc"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `all valid return true`() {
        val result = RegistrationUtils.validationOnRegistration(
            "qwert",
            "9898989898",
            "abc",
            "abc"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `userName taken  return false`() {
        val result = RegistrationUtils.validationOnRegistration(
            "Ram",
            "9898989898",
            "abc",
            "abc"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `phone number taken  return false`() {
        val result = RegistrationUtils.validationOnRegistration(
            "Ram",
            "9999999999",
            "abc",
            "abc"
        )
        assertThat(result).isFalse()
    }
}
