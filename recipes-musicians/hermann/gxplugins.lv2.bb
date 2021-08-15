SUMMARY = "A set of extra lv2 plugins from the guitarix project"
HOMEPAGE = "https://github.com/brummer10/GxPlugins.lv2"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84dcc94da3adb52b53ae4fa38fe49e5d"

SRC_URI = "gitsm://github.com/brummer10/GxPlugins.lv2.git"
SRCREV = "e40b34f3fd5dc4c6523dc826062d0ddb2578f573"
S = "${WORKDIR}/git"
PV = "0.8"

inherit pkgconfig features_check

REQUIRED_DISTRO_FEATURES = "x11"

DEPENDS += " \
    cairo \
    virtual/libx11 \
    lv2 \
"

do_compile() {
    export GUI_LDFLAGS="${LDFLAGS}"
    oe_runmake SSE_CFLAGS= STRIP=echo 
}

do_install() {
    oe_runmake DESTDIR=${D} PREFIX=${prefix} INSTALL_DIR=${libdir}/lv2 install
}


FILES:${PN} += "${libdir}/lv2"
