# TODO
## Item System
### New Class: Item extends GameObject
#### Item - Attributes
- Nutritional value? - no - interface Edible
- currency value? 
- weight? / inventory slots?
#### Item - Subclasses
consumable
### New Interfaces
- Sellable
- BuyAble?
- Edible
- Drinkable? or combined Consumable? -> Interface Consume for characters
- CarrieAble? are all Items CarrieAble?
### Inventory
- Only player? - no -> Interface Inventory or attribute of Class Inventory
## Looting
- Scenes need to generate with items
- Npcs must carry items
## Talk interaction
### New Interface: Talk
## Inspect interaction
See Properties of Items and Characters upon Inspection
## Search interaction
### new interface searchable
- method searchInventory by item name
- enforce method getItemByName