package functionalKotlin.list

import org.junit.jupiter.api.Test
import strikt.api.expect
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isLessThan
import strikt.assertions.isTrue
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class AdditionTest {

    @Test
    fun `add two numbers`() {
        expectThat(5 + 6).isEqualTo(11)
        expectThat(7 + 42).isEqualTo(49)
        expectThat(9999 + 1).isEqualTo(10000)
    }

    fun randomNatural() = Random.nextInt(from = 1, until = 100_000_000)

    @Test
    fun `zero identity`() {
        repeat(100) {
            val x = randomNatural()

            expectThat(x + 0).isEqualTo(x)
        }
    }

    @Test
    fun `commutative property`() {
        repeat(100) {
            val x = randomNatural()
            val y = randomNatural()

            expectThat(x + y).isEqualTo(y + x)
        }
    }

    @Test
    fun `associative property`() {
        repeat(100) {
            val x = randomNatural()
            val y = randomNatural()
            val z = randomNatural()

            expect {
                that(x + (y + z)).isEqualTo((x + y) + z)
                that(y + (x + z)).isEqualTo((y + z) + x)
                that(z + (x + y)).isEqualTo((z + x) + y)
            }
        }
    }

    @Test
    fun `adding 1 to min value eventually is equal to max value`() {
        val x = randomNatural()
        val y = randomNatural()
        val minimum = min(x, y)
        val maximum = max(x, y)
        var t = minimum

        expectThat(minimum).isLessThan(maximum)

        var go = true
        while (go) {
            t = t + 1
            if (t == maximum) {
                expectThat(true).isTrue()
                break
            }
        }
    }
}
