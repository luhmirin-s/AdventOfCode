package core.extensions

import org.intellij.lang.annotations.Language

@Language("RegExp")
inline fun <reified T : Any> List<String>.mapToPattern(
    pattern: String,
    crossinline mapper: (MatchGroupCollection) -> T?
) = mapNotNull { Regex(pattern).matchEntire(it)?.groups?.let(mapper) }

@Language("RegExp")
inline fun <reified T : Any> List<String>.mapToPatternIndexed(
    pattern: String,
    crossinline mapper: (Int, MatchGroupCollection) -> T?
) = mapIndexedNotNull() { i, s -> Regex(pattern).matchEntire(s)?.groups?.let { mapper(i, it) } }

fun MatchGroupCollection.getString(i: Int, default: String = "") = this[i]?.value ?: default
fun MatchGroupCollection.getInt(i: Int, default: Int = 0) = this[i]?.value?.toIntOrNull() ?: default
inline fun MatchGroupCollection.getBoolean(i: Int, default: Boolean = false, predicate: (String) -> Boolean) =
    this[i]?.value?.let(predicate) ?: default