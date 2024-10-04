# frozen_string_literal: true
module Irrgarten
  class Weapon
    attr_reader :power, :uses

    def initialize(power,uses)
      @power = power.to_f
      @uses = uses.to_i
    end

    def attack
      if @uses > 0
        @uses -= 1
        @power
      else
        0
      end
    end

    def to_s
      "W[#{@power},#{@uses}]"
    end

    def discard
      Dice.discard_element(@uses)
    end
  end
end