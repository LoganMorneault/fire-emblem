
Note to anyone reading! I just started this and likely won't have a lot of time to work on it, but it's here if you want to take a peek at how I design Java classes and methods. This is currently based pretty heavily on Fire Emblem (more specifically Fire Emblem: Heroes), which is an excellent video game franchise. In the future, I'd like to split off somehow, but my initial goal is just to make a working FE battle simulator.

To Do: 
 - Unit testing! It's very late and I am sleepy, but I really should have started with this!
 - Make game playable: this will eventually require command prompt input. The current goal is to make this text based in console.
 - Create abstract AWeapon to minimize duplicate code. 
    - Potentially extend this to ASword, AAxe, ALance, ABow, ARedTome, although that may not be worth the effort.
 - Add JavaDoc to IHero, should have happened earlier but I am sleepy.


I might not do these, but we'll see how in-depth I want to get.

Far off:
 - Graphics, grid based combat using Swing.
 - More stats? Add skill stat and crit chance?
 - Abilities: Add one ability to each character, implemented in their attack method.
 - Weapon Effectiveness: Add 20% bonus for weapon triangle advantage.
    - Add color to weapons.
 - Add unit types: armored, cavalry, flying, implemented in an enum
    - Methods: movement, attack for effectiveness.