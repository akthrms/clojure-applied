(ns ch02.pair
  (:import [clojure.lang Counted ILookup Indexed Seqable]))

(deftype Pair [a b]
  Seqable
  (seq [_]
    (seq [a b]))

  Counted
  (count
    [_] 2)

  Indexed
  (nth [_ i]
    (case i
      0 a
      1 b
      (throw (IllegalArgumentException.))))
  (nth [this i _]
    (nth this i))

  ILookup
  (valAt [_ k _]
    (case k
      0 a
      1 b
      (throw (IllegalArgumentException.))))
  (valAt [this k]
    (.valAt this k nil)))

; (def p (->Pair :a :b))
; => #'ch02.pair/p
; (seq p)
; => (:a :b)
; (count p)
; => 2
; (nth p 1)
; => :b
; (get p 0)
; => :a
; p
; => #object[ch02.pair.Pair 0xfeae65b "ch02.pair.Pair@feae65b"]
