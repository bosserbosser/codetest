#!/usr/bin/env scala

// Stream is deprecated, go for LazyList instead

assert( LazyList(1,2,3).tail.tail.tail == LazyList.empty )
assert( LazyList.empty == Stream.empty )

