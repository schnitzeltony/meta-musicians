require zyn.inc

SUMMARY = "Zyn-Fusion is an open source software synthesizer"

EXTRA_OECMAKE += "-DGuiModule=zest"

FILES:${PN} += " \
    ${datadir}/zynaddsubfx \
"

RDEPENDS:${PN} += "mruby-zest"

RREPLACES:${PN} += "zynaddsubfx"
RCONFLICTS:${PN} += "zynaddsubfx"
