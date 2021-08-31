# FoxAPI

## Table Of Contents:
****
- [Introduction](#introduction)
- [Installation](#installation)
    - [Maven](#maven)
- [Functions]()
    - [Item Builder](#item-builder)
    - [Skull]()

## Introduction
****
FoxApi is my personal Api to help me in the developpement of my plugins.  
If you have an improvement or an issue, just report it.  
This Api implements many stuff that can help you.

## Installation

### Maven

#### Repository
```xml
<repositories>
    <repository>
        <id></id>
        <url></url>
    </repository>
</repositories>
```
#### Dependency
```xml
<dependency>
    <groupId></groupId>
    <artifactId></artifactId>
    <version></version>
</dependency>
```

## Functions

### Item Builder
****
I make a Item Builder call the FoxBuilder to help to create easily your itemStack
```java
FoxBuilder foxBuilder = new FoxBuilder(Material.GRASS);
```
When you have finish your FoxBuilder you can convert to a ItemStack
```java
ItemStack itemStack = foxBuilder.toItemStack();
```
If you have a FoxBuilder you can re-edit with a new FoxBuilder
```java
FoxBuilder newFoxBuilder = new FoxBuilder(foxBuilder);
```
If you have a ItemStack you can modify too with the FoxBuilder
```java
FoxBuilder newFoxBuilder = new FoxBuilder(itemStack);
```
In the instance of your FoxBuilder you can modify the amount of your ItemStack and the durability
```java
FoxBuilder foxBuilder = new FoxBuilder(Material.GRASS, 1, (short) 3);
```
With this ItemBuilder I have add 36 methods to edit your ItemStack
```java
FoxBuilder foxBuilder = new FoxBuilder(Material.GRASS, 1, (short) 3);
        foxBuilder.setDisplayName("An Item");
        foxBuilder.setUnbreakable();
        foxBuilder.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);;
        foxBuilder.setLore("This is a lore");
```

#### Skull
With this ItemBuilder you can make skull easily with different way to create
```java
new FoxBuilder(new Skull("url"));
new FoxBuilder(new Skull(uuid));
new FoxBuilder(new Skull().skullFromBase64("base64"));
new FoxBuilder(new Skull().skullFromName(playerName));
```

##### Note:

For the creation of the skull i use some method of the [library](https://github.com/deanveloper/SkullCreator/blob/master/src/main/java/dev/dbassett/skullcreator/SkullCreator.java) SkullCreator by [Dean B](https://github.com/deanveloper)







  
     
 
  

  





