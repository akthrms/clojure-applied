(ns ch01.validate
  (:require [schema.core :as s]))

(defrecord Ingredient [name
                       quantity
                       unit])

(defrecord Recipe [name
                   description
                   ingredients
                   steps
                   servings])

(def spaghetti-tacos
  (map->Recipe {:name        "Spaghetti tacos"
                :description "It's a spaghetti... in a taco."
                :ingredients [(->Ingredient "Spaghetti" 1 :lb)
                              (->Ingredient "Spaghetti sauce" 16 :oz)
                              (->Ingredient "Taco shell" 12 :shell)]
                :steps       ["Cook spaghetti according to box."
                              "Heat spaghetti sauce until warm."
                              "Mix spaghetti and sauce."
                              "Put spaghetti in taco shells and serve."]
                :servings    4}))

(s/defrecord Ingredient [name :- s/Str
                         quantity :- s/Int
                         unit :- s/Keyword])

(s/defrecord Recipe [name :- s/Str
                     description :- s/Str
                     ingredients :- [Ingredient]
                     steps :- [s/Str]
                     servings :- s/Int])
