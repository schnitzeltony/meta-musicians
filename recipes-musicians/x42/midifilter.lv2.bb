SUMMARY = "LV2 plugins to filter midi events"
HOMEPAGE = "http://x42.github.io/midifilter.lv2/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=4641e94ec96f98fabc56ff9cc48be14b"

inherit pkgconfig

DEPENDS += "lv2"

SRC_URI = "git://github.com/x42/midifilter.lv2.git"
SRCREV = "a93918c11d0e9b8b8a14f2f4041b8e5963239962"
PV = "0.6.4"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    STRIP=echo \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES_${PN} += "${libdir}/lv2"
