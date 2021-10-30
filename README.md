# Las flipantes aventuras de Marco y Luis [ඞ](https://youtu.be/0bZ0hkiIKt0)

This game is a clone of the RPG Mario and Luigi game (see [Mario Wiki](https://mario.fandom.com/es/wiki/Mario_%26_Luigi_RPG)).
In this project will implement an RPG combat system between two main characters (Marco and Luis) against different enemies
controlled by the computer.

### - Characters
We have two playable characters, Marco and Luis. These characters have different stats that will define their battle performance:

- _Level_ (LVL): Character level. This stat will allow upgrade the another properties.
- _Attack_ (ATK): Character damage power.
- _Defense_ (DEF): Allows to decrease the damage received.
- _Health points_ (HP): Character's health. Allows to be in combat.
- _Fighting Points_ (FP): Used to realize attacks. Different attacks need different FP values.

Every main characters have two attacks:

- __Jump__ (Normal attack): Low damage attack. Cost 1 Fp and has 100% hit probability. Damage constant K = 1.
- __Hammer__ (Super attack) High damage attack. Cost 2 Fp and has 75% hit probability. Damage constant K = 1.5 .

The deal damage is calculated as:

<img src="https://latex.codecogs.com/png.latex?damage&space;=&space;\frac{K(atk_{a})(lvl_{a})}{def_{b}}" title="damage = \frac{K(atk_{a})(lvl_{a})}{def_{b}}" />

Where "a" is the attacker and "b" the attacked.

### - Enemies
In this game exists many enemies which will face with Marco and Luis:

- [__Goomba__](https://mario.fandom.com/wiki/Goomba): Generic enemy. Attacks with normal attacks. Can be defeated by Marco and Luis with any attack.
- [__Spiny__](https://mario.fandom.com/wiki/Spiny): Turtle-like enemy with a spike shell. If someone attack with a normal attack, he doesn't receive damage and bring back
  damage equivalent to 5% attacker Hp. Can be defeated with Hammers attacks from Marco and Luis.
- [__Boo__](https://mario.fandom.com/wiki/Boo): A ghost enemy. Only attacks Luis. He dodges hammers attacks and Luis attacks. Can be defeated by Marco normals attacks.

These enemies have a Damage constant K=0.75.

### - Attacks table

|Attack | Marco | Luis  | Goomba | Spiny | Boo  |
|:----:|:----:|:----:|:----:|:----:|:----:|
| Marco |       |       |    ✓    |    ✓   |   ✓ | 
|  Luis |       |       |    ✓   |    ✓   |    x  | 
|Goomba |   ✓    |    ✓   |       |       |       | 
| Spiny |    ✓   |   ✓    |       |       |       | 
| Boo   |  x     |    ✓   |       |       |       | 


### - How to play
Actually, the game is in developing. But we can test the implementations made at this moment. In the folder [test](src/test) you can verify the different
objects and theirs methods. Just run it with any IDE (InteliJ IDEA ideally).