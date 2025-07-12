# Personas

## Road Map

- [ ] **1.0.0** - Initial release with no support for plugins (basic Persona switching, permissions, inventories, etc. - vanilla features)
- [ ] **1.1.0** - Support for Vault, allowing for dynamic permission and economy management per Persona
- [ ] **1.2.0** - Support more plugins (will have to make research of which plugins are most used + players feedback)

This plugin revolutionizes player identity by allowing a single user account to hold multiple, distinct profiles—or "Personas."
Empower your staff and players to seamlessly switch between roles like Admin, Builder, or a roleplay character without needing multiple accounts.
Personas keeps inventories, permissions, and player data completely separate, all managed through simple, intuitive commands or graphical interfaces.
It’s a powerful, lightweight, and essential tool for modern server management.

## Core Features

### Seamless Persona Switching

Tired of the hassle of logging in and out to switch between your staff and player accounts?
Or wish you could have a separate profile for creative building and survival gameplay?
Personas provides a clean, in-game solution.

- **Simple Command System**: Players can switch between their allowed Personas using a straightforward command, like `/persona switch <name>`. The transition is instant and seamless.

- **Profile Isolation**: Each Persona maintains its own separate inventory, Ender Chest, experience level, advancements, and even data from other plugins. Swapping profiles means swapping your entire gameplay state.

- **Customizable Limits**: As an admin, you control everything. Define how many Personas a player can create, which ones they have access to, and set cooldowns or costs for switching to maintain server balance.

<br />

### Dynamic Permission & Role Syncing

A player's Persona is more than just their inventory; it's their role on the server.
Personas is designed to integrate deeply with the permission and economy plugins you already use.

- **Automatic Group Swapping**: When a player switches to their "Admin" Persona, they are automatically placed into the corresponding LuckPerms/Vault group. Switch back to their "Player" Persona, and their admin permissions are instantly revoked. This ensures security and role integrity.

- **Per-Persona Economy**: Hook into Vault to give each Persona its own separate bank balance. A player's staff duties won't interfere with their survival economy, and vice-versa.

- **Enhanced Roleplay**: Create specific Personas for different jobs or classes on a roleplaying server, each with its own unique permissions, stats, and inventory, opening up new possibilities for immersive gameplay.

<br />

### Why Choose Personas?

- **Eliminates Multi-Accounting**: Drastically simplifies server management for both players and staff. No more whitelisting multiple accounts for one person or confusing /sudo commands.

- **Lightweight & Efficient**: Built for performance. Personas manages player data intelligently to ensure it adds powerful features without creating lag or performance bottlenecks.

- **Fully Configurable**: Every message, setting, and feature can be tailored. Configure which data is saved per Persona (inventories, XP, location, etc.) and create a system that fits your server's unique needs perfectly.

- **Secure & Robust**: By linking permissions directly to the active Persona, you ensure that powerful abilities are only accessible when a player is in the correct context, minimizing the risk of abuse.

<br />

## Currently Supported Custom Enchantment Plugins

| Plugin | 1.21.7 - 1.21 | 1.20.6 - 1.20.5 | 1.20.4 - 1.18 |
|--------|---------------|-----------------|---------------|
| TODO   | &cross;       | &cross;         | &cross;       |

<br />

## Commands

- Visit the [COMMANDS.md](COMMANDS.md) file to learn when to use a specific command

<br />

## Permissions

- Visit the [PERMISSIONS.md](PERMISSIONS.md) file to learn more about permissions and their use cases

<br />

## Configuration

- Visit the [CONFIG.md](CONFIG.md) file to understand every setting this plugin has to offer

<br />

## Contributing

> To contribute to this repository, please follow the [CONTRIBUTING.md](CONTRIBUTING.md) file, thank you!

<br />

## Known issues

- TBD

<br />
<br />

## Links

- [SpigotMC]() TBD
- [Modrinth]() TBD
- [bStats]() TBD
- [GitHub](https://github.com/H7KZ/Personas)
