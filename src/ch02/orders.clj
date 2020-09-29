(ns ch02.orders
  (:import [clojure.lang PersistentQueue]))

(def new-orders PersistentQueue/EMPTY)

(defn add-order [orders order]
  (conj orders order))

(defn cook-order [orders]
  (cook (peek orders))
  (pop orders))
