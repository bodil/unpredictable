# Unpredictable

Unpredictable is a collection of Clojure functions for producing
randomness.

## Usage

Add the dependency to your project.clj:

```clojure
[unpredictable "0.1.0"]
```

Now use it like this:

```clojure
;; Make a set of 5 distinct items from the sequence
> (rand-from-seq 5 (range 10))
#{1 2 3 6 7}

;; Map 3 random items from the sequence through str
> (rand-map 3 str (range 10))
(0 1 2 "3" "4" 5 6 7 "8" 9)
```

## License

Copyright © 2012 Bodil Stokke

Distributed under the Eclipse Public License, the same as Clojure.
