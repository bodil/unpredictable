(ns unpredictable.core)

(defn rand-from-seq
  "Produce a set of n distinct items from seq, chosen at random.

Make sure there _are_ n distinct items in seq, or this function
will loop forever."
  [n seq]
  (let [seq (vec seq) n (int n)]
    (loop [res #{}]
      (if (= n (count res)) res
          (let [item (rand-nth seq)]
            (recur (conj res item)))))))

(defn rand-map
  "Map n random items from s through f, leaving other items
unchanged."
  [n f s]
  (let [rands (rand-from-seq n (range (count s)))
        produce
        (fn produce [s index]
          (lazy-seq
           (if (not (seq s)) ()
               (let [item (first s)
                     mapped (if (contains? rands index)
                              (f item) item)]
                 (cons mapped (produce (rest s) (inc index)))))))]
    (produce s 0)))
