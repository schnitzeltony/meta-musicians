SUMMARY = "Simple Scope"
HOMEPAGE = "http://x42.github.io/sisco.lv2/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit pkgconfig

DEPENDS += " \
    virtual/libgl \
    libglu \
    lv2 \
    jack \
"

SRC_URI = "gitsm://github.com/x42/sisco.lv2.git"
SRCREV = "428b66f49c81e72dfc7dd64f628b879467fe04c1"
PV = "0.8.5"
S = "${WORKDIR}/git"

EXTRA_OEMAKE += " \
    STRIP=echo \
    OPTIMIZATIONS= \
"

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} LV2DIR=${libdir}/lv2 install
}

FILES_${PN} += "${libdir}/lv2"
