# iOS backend — hand-written / stub registry

**GENERATED — do not edit. Run `python3 scripts/ios_handwritten_report.py`.**

Every hand-written, stubbed, or sugar site in the iOS backend, from the in-code
`// KANAMA-IOS-{STUB,HANDWRITTEN,SUGAR}` markers. The point: nothing silently no-ops
without being listed here, so we don't repeat the deep-dive bugs from unwired
annotations/signals. `scripts/check_ios_no_silent_stubs.py` fails CI on an
un-annotated bare-default return.

Totals: **0 STUB** · **10 HANDWRITTEN** · **0 SUGAR** (10 marked sites).

## STUB

_Silent stubs — should call real Godot but don't yet (follow up to avoid silent-no-op bugs)._

_(none)_

## HANDWRITTEN

_Intentionally bespoke — not generatable from extension_api.json; correct as-is._

| Location | Note |
|---|---|
| `ios-runtime/src/iosMain/kotlin/net/multigesture/kanama/api/IosGodotApi.kt:109` | KanamaScope bridges Godot's main thread to Kotlin coroutines; not generatable from extension_api.json. |
| `ios-runtime/src/iosMain/kotlin/net/multigesture/kanama/api/IosGodotApi.kt:123` | MainThread.post is a no-op shim; on iOS main thread dispatch is handled by Godot's frame loop, not a JVM executor. |
| `ios-runtime/src/iosMain/kotlin/net/multigesture/kanama/api/IosGodotApi.kt:140` | signal/connect/emitSignal/await use the custom GDExtension |
| `ios-runtime/src/iosMain/kotlin/net/multigesture/kanama/api/IosGodotApi.kt:196` | AutoCloseable no-op base; Godot object lifetime is managed externally, not by Kotlin's close(). |
| `ios-runtime/src/iosMain/kotlin/net/multigesture/kanama/api/IosGodotApi.kt:338` | Tweener/PropertyTweener/Tween use the Variant tween_property path |
| `ios-runtime/src/iosMain/kotlin/net/multigesture/kanama/api/IosGodotApi.kt:406` | Input is the bespoke singleton glue (getSingleton + cached binds); |
| `ios-runtime/src/iosMain/kotlin/net/multigesture/kanama/api/IosGodotApi.kt:431` | pure-Kotlin math helpers (no Godot call). Bespoke utility. |
| `ios-runtime/src/iosMain/kotlin/net/multigesture/kanama/api/IosGodotApi.kt:453` | ResourceLoader singleton glue over the C shim resource loader. |
| `ios-runtime/src/iosMain/kotlin/net/multigesture/kanama/api/IosGodotApi.kt:466` | GD global helpers (rand*, print) — Kotlin/native impls, bespoke. |
| `ios-runtime/src/iosMain/kotlin/net/multigesture/kanama/api/IosGodotApi.kt:491` | thin cinterop facade over the C shim helpers used by the bespoke |

## SUGAR

_Hand-added inside a GENERATED wrapper file — regeneration overwrites it; re-add after._

_(none)_

