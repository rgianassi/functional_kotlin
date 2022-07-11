/**
 * The main function.
 */

package functionalKotlin.app

import functionalKotlin.utilities.StringUtils
import org.apache.commons.text.WordUtils

@Suppress("diktat")
fun main() {
    val tokens = StringUtils.split(MessageUtils.getMessage())
    val result = StringUtils.join(tokens)
    println(WordUtils.capitalize(result))
}
