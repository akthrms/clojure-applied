(ns ch02.update
  (:require [medley.core :refer [map-keys map-vals]]))

(defn keywordize-entity [entity]
  (map-keys keyword entity))

(keywordize-entity {"name"       "Earth"
                    "moons"      1
                    "volume"     1.08321e12
                    "mass"       5.97219e24
                    "aphelion"   152098232
                    "perihelion" 147098290})
; => {:name "Earth",
;     :moons 1,
;     :volume 1.08321E12,
;     :mass 5.97219E24,
;     :aphelion 152098232,
;     :perihelion 147098290}

(defn- update-calories [recipe]
  (assoc recipe :calories (compute-calories recipe)))

(defn include-calories [recipe-index]
  (map-vals update-calories recipe-index))
