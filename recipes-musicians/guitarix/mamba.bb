SUMMARY = "Virtual Midi Keyboard for Jack Audio Connection Kit"
HOMEPAGE = "https://github.com/brummer10/Mamba"
LICENSE = "BSD-0-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1a396d84ed72b4a017f02f5c5d1eaafe"

SRC_URI = " \
    gitsm://github.com/brummer10/Mamba.git \
    file://0001-Create-destination-dirs-in-case-they-do-not-exist.patch \
"
SRCREV = "076f382cc17416413dc05fad00a37273736231d3"
S = "${WORKDIR}/git"
PV = "1.0"

inherit pkgconfig features_check

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    cairo \
    virtual/libx11 \
    libsigc++-2.0 \
    lv2 \
    liblo \
    jack \
"

do_compile() {
    oe_runmake SSE_CFLAGS= STRIP=echo 
}

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} install
}
