package com.example.pracproject

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FibonacciUtilsTest() {

    @Test
    fun `result not eqaul to 1 return false`() {
        assertThat(FibonacciUtils.fibonacciValid(1)).isEqualTo(1)
    }

    @Test
    fun `result not eqaul to 0 return false`() {
        assertThat(FibonacciUtils.fibonacciValid(3)).isEqualTo(2)
    }

    @Test
    fun `actual result return false`() {
        assertThat(FibonacciUtils.fibonacciValid(30)).isEqualTo(832040)
    }
}
