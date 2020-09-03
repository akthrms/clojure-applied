(ns ch01.protocols
  (:import [ch01.validate Ingredient Recipe])
  (:require [ch01.money :refer [zero-dollars +$]]))

(defrecord Store [])

(defn cost-of [_store _ingredient])

(defprotocol Cost
  (cost [entity store]))

(extend-protocol Cost
  Recipe
  (cost [recipe store]
    (reduce +$ zero-dollars (map #(cost % store) (:ingredients recipe))))

  Ingredient
  (cost [ingredient store]
    (cost-of store ingredient)))
