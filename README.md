# Painless Language Syntax Highlighting

| Light | Dark |
|:-----:|:----:|
| <img src="src/main/resources/icons/painless.svg" width="64" height="64"> | <img src="src/main/resources/icons/painless_dark.svg" width="64" height="64"> |

[![Build](https://github.com/Traackr/intellij-plugin-painless-syntax-highlighting/workflows/Build/badge.svg)](https://github.com/Traackr/intellij-plugin-painless-syntax-highlighting/actions)
[![Version](https://img.shields.io/jetbrains/plugin/v/com.traackr.painless.svg)](https://plugins.jetbrains.com/plugin/com.traackr.painless)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/com.traackr.painless.svg)](https://plugins.jetbrains.com/plugin/com.traackr.painless)

<!-- Plugin description -->
**Painless Language Syntax Highlighting** provides syntax highlighting for Elasticsearch's Painless scripting language in IntelliJ-based IDEs.

## Features

- Syntax highlighting for `.painless` files
- Keyword highlighting (`if`, `else`, `for`, `while`, `return`, `try`, `catch`, etc.)
- Type highlighting (`def`, `int`, `long`, `boolean`, `String`, etc.)
- Literal highlighting (strings, numbers, booleans, regex patterns)
- Operator highlighting (including Painless-specific operators like `?.`, `?:`, `=~`, `==~`)
- Comment support (`//` and `/* */`)
- Brace matching
- Comment toggling (Cmd/Ctrl + /)

## Supported Syntax

Based on the [official Elasticsearch Painless ANTLR grammar](https://github.com/elastic/elasticsearch/tree/main/modules/lang-painless/src/main/antlr):

- **Keywords**: `if`, `else`, `while`, `do`, `for`, `in`, `continue`, `break`, `return`, `new`, `try`, `catch`, `throw`, `this`, `instanceof`
- **Types**: `boolean`, `byte`, `short`, `char`, `int`, `long`, `float`, `double`, `def`, `void`
- **Operators**: All arithmetic, comparison, logical, bitwise, and assignment operators, plus Painless-specific `?.` (null-safe), `?:` (elvis), `->` (lambda), `::` (method reference), `=~`/`==~` (regex match)
- **Literals**: Strings (single/double quoted), numbers (decimal, hex, octal), booleans, null, regex patterns

<!-- Plugin description end -->

## Installation

### From JetBrains Marketplace

1. Open your IntelliJ-based IDE
2. Go to `Settings/Preferences` → `Plugins` → `Marketplace`
3. Search for "Painless Language Syntax Highlighting"
4. Click `Install`

### Manual Installation

1. Download the latest release from [GitHub Releases](https://github.com/Traackr/intellij-plugin-painless-syntax-highlighting/releases)
2. Go to `Settings/Preferences` → `Plugins` → `⚙️` → `Install Plugin from Disk...`
3. Select the downloaded `.zip` file

## Usage

Simply create or open a file with the `.painless` extension. The plugin will automatically provide syntax highlighting.

## Building from Source

```bash
./gradlew buildPlugin
```

The plugin ZIP will be created in `build/distributions/`.

## License

MIT License - see [LICENSE](LICENSE) for details.

## Credits

- Syntax grammar based on [Elasticsearch's official Painless ANTLR grammar](https://github.com/elastic/elasticsearch/tree/main/modules/lang-painless/src/main/antlr)
- Built using the [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)
