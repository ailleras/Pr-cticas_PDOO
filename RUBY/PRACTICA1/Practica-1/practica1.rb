module Directions
  LEFT =:left
  RIGHT =:right
  UP =:up
  DOWN =:down
end

module Orientation
  VERTICAL =:vertical
  HORIZONTAL =:horizontal
end

module GameCharacter
  PLAYER =:player
  MONSTER =:monster
end


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

class Shield
  attr_reader :protection, :uses

  def initialize(protection,uses)
    @protection = protection.to_f
    @uses = uses.to_i
  end

  def protect
    if @uses > 0
      @uses -= 1
      @protection
    else
      0
    end
  end

  def to_s
    "W[#{@protection},#{@uses}]"
  end

  def discard
    Dice.discard_element(@uses)
  end
end

class Dice
  @@MAX_USES = 5
  @@MAX_INTELLIGENCE = 10.0
  @@MAX_STRENGTH = 10.0
  @@RESURRECT_PROB = 0.3
  @@MAX_RESURRECT_PROB = 1.0
  @@WEAPONS_REWARD = 2
  @@SHIELDS_REWARD = 3
  @@HEALTH_REWARD = 5
  @@MAX_ATTACK = 3
  @@MAX_SHIELD = 2

  @@generator = Random.new

  class << self
    attr_reader :MAX_USES, :MAX_INTELLIGENCE, :MAX_STRENGTH
    attr_reader :RESURRECT_PROB, :WEAPONS_REWARD, :SHIELDS_REWARD, :HEALTH_REWARD
    attr_reader :MAX_ATTACK, :MAX_SHIELD

    def roll(sides=6)
      @@generator.rand(1..sides)
    end
  end
end


def self.random_pos(max)
  raise ArgumentError, "EL valor tiene que ser mayor a 0" if max <= 0

  @@generator.rand(0...max)
end

def self.who_starts(nplayers)
  raise ArgumentError, "El numero de jugadores tiene que ser mayor a 0" if nplayers <= 0

  @@generator.rand(0...nplayers)
end

def self.random_intelligente
  @@generator.rand(0...MAX_INTELLIGENCE)
end

def self.random_strength
  @@generator.rand(0...MAX_STRENGTH)
end

def self.resurrect_player
  @@generator.rand(0...MAX_RESURRECT_PROB) < RESURRECT_PROB
end

def self.weapons_reward
  @@generator.rand(0...WEAPONS_REWARD)
end

def self.shields_reward
  @@generator.rand(0...SHIELDS_REWARD)
end

def self.health_reward
  @@generator.rand(0...HEALTH_REWARD)
end

def self.weapon_power
  @@generator.rand(0...MAX_ATTACK)
end

def self.shield_power
  @@generator.rand(0..MAX_SHIELD)
end

def self.uses_left
  @@generator.rand(0..MAX_USES)
end

def self.intensity(competence)
  @@generator.rand(0...competence)
end

def self.discard_element(uses_left)
  if @@generator.rand(1..@@MAX_USES) > uses_left
    return true
  end
  false
end

class GameState
  attr_reader :labyrinth, :players, :monsters, :current_player, :winner, :log

  def initialize(labyrinth, players, monsters, current_player, winner, log)
    @labyrinth = labyrinth
    @players = players
    @monsters = monsters
    @current_player = current_player
    @winner = winner
    @log = log
  end
end