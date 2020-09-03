(ns ch01.multimethods
  (:import [ch01.validate Ingredient Recipe])
  (:require [ch01.money :refer [zero-dollars +$]]))

(defrecord Store [])

(defn cost-of [_store _ingredient])

(defmulti cost (fn [entity _store] (class entity)))

(defmethod cost Recipe [recipe store]
  (reduce +$ zero-dollars (map #(cost % store) (:ingredients recipe))))

(defmethod cost Ingredient [ingredient store]
  (cost-of store ingredient))
