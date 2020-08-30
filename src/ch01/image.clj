(ns ch01.image
  (:import [java.awt.image BufferedImage]
           [javax.imageio ImageIO])
  (:require [clojure.java.io :as io]))

(defrecord PlanetImage [src ^BufferedImage contents])

(defn make-planet-image
  "Make a PlantImage; may throw IOException"
  [src]
  (with-open [img (ImageIO/read (io/input-stream str))]
    (->PlanetImage src img)))
