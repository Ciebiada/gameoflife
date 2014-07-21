(ns gameoflife.core-test
  (:require [clojure.test :refer :all]
            [gameoflife.core :refer :all]))

(deftest cell-with-two-neighbours-survives
  (is ((next-generation #{[0 0] [1 0] [2 0]}) [1 0])))

(deftest cell-with-fewer-than-two-neighbours-dies
  (is (not ((next-generation #{[0 0] [1 0] [2 0]}) [0 0]))))

(deftest dead-cell-with-three-neighbours-becomes-alive
  (is ((next-generation #{[0 0] [1 0] [2 0]}) [1 1])))

(deftest cell-with-more-than-three-neighbours-dies
  (is (not ((next-generation #{[0 0] [1 0] [2 0] [0 1] [1 1] [2 1]}) [1 0]))))
