(ns ch02.pair.print
  (:import [ch02.pair Pair]
           [java.io Writer]))

(defmethod print-method Pair [pair ^Writer w]
  (.write w "#ch02.pair.Pair")
  (print-method (vec (seq pair)) w))

(defmethod print-dup Pair [pair w]
  (print-method pair w))

; (->Pair 1 2)
; => #ch02.pair.Pair[1 2]
; #ch02.pair.Pair[3 4]
; => #ch02.pair.Pair[3 4]
