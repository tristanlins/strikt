package assertions

fun <T> Assertion<T?>.isNull(): Assertion<Nothing> =
  if (target != null) {
    throw AssertionError("Expected $target to be null")
  } else {
    @Suppress("UNCHECKED_CAST")
    this as Assertion<Nothing>
  }

fun <T> Assertion<T?>.isNotNull(): Assertion<T> =
  if (target == null) {
    throw AssertionError("Expected $target not to be null")
  } else {
    Assertion(target)
  }

inline fun <reified T> Assertion<*>.isA(): Assertion<T> =
  when (target) {
    null -> throw AssertionError("Expected $target to be an instance of ${T::class.java.name} but it is null")
    is T -> Assertion(target)
    else -> throw AssertionError("Expected $target to be an instance of ${T::class.java.name} but it is a ${target.javaClass.name}")
  }
