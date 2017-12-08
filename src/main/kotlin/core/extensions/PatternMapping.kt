package core.extensions

inline fun <reified T : Any> List<String>.mapToPattern(
    pattern: String,
    crossinline mapper: (MatchGroupCollection) -> T?
) = mapNotNull { Regex(pattern).matchEntire(it)?.groups?.let(mapper) }

fun MatchGroupCollection.getString(i: Int, default: String = "") = this[i]?.value ?: default
fun MatchGroupCollection.getInt(i: Int, default: Int = 0) = this[i]?.value?.toIntOrNull() ?: default
inline fun MatchGroupCollection.getBoolean(i: Int, default: Boolean = false, predicate: (String) -> Boolean) =
    this[i]?.value?.let(predicate) ?: default