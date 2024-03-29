SUMMARY = "Virtual Midi Keyboard for Jack Audio Connection Kit"
HOMEPAGE = "https://github.com/brummer10/Mamba"
LICENSE = "0BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1a396d84ed72b4a017f02f5c5d1eaafe"

SRC_URI = "gitsm://github.com/brummer10/Mamba.git;branch=master;protocol=https"
SRCREV = "46bdd97df02b93c30eb6f7a1782e2ee454979e87"
PV = "2.3"
S = "${WORKDIR}/git"

inherit pkgconfig features_check mime-xdg gettext

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    vim-native \
    cairo \
    virtual/libx11 \
    libsigc++-2.0 \
    lv2 \
    liblo \
    jack \
    fluidsynth \
    libsmf \
"

do_compile() {
    oe_runmake SSE_CFLAGS= STRIP=echo 
}

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} install
}
