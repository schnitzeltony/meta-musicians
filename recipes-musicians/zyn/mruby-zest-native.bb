require ${BPN}.inc

inherit native

DEPENDS += " \
    libuv-native \
"

do_install() {
    install -d ${D}${bindir}
    install -m 755 ${B}/mruby/build/host-debug/bin/mrbc ${D}${bindir}/mrbc-zest
}
