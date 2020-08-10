SUMMARY = "Virtual Midi Keyboard for Jack Audio Connection Kit"
HOMEPAGE = "https://github.com/brummer10/Mamba"
LICENSE = "BSD-0-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1a396d84ed72b4a017f02f5c5d1eaafe"

SRC_URI = "gitsm://github.com/brummer10/Mamba.git"
SRCREV = "f4289a3dadff2640860f37ecbb379c21fe820408"
PV = "1.1"
S = "${WORKDIR}/git"

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
