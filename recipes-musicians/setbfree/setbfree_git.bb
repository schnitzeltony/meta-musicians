SUMMARY = "A DSP Tonewheel Organ emulator"
HOMEPAGE = "http://setbfree.org/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=4641e94ec96f98fabc56ff9cc48be14b"

inherit pkgconfig gtk-icon-cache

DEPENDS += " \
    virtual/libgl \
    pango \
    cairo \
    libglu \
    ftgl \
    jack \
    liblo \
    lv2 \
    zita-convolver \
    libsndfile1 \
"

SRC_URI = " \
    git://github.com/pantherb/setBfree.git;branch=master;protocol=https \
    file://0001-remove-UINQHACK-it-is-used-for-OSX-builds-only-and-c.patch \
    file://0002-Do-not-check-for-fontfile.patch \
    file://setbfree.desktop \
    file://x42-whirl.desktop \
"
SRCREV = "93e7f154bee67590d6d321a572a1b107f8fc36e1"
S = "${WORKDIR}/git"
PV = "0.8.11"

EXTRA_OEMAKE += " \
    STRIP=echo \
    FONTFILE=${prefix}/share/fonts/ttf/VeraBd.ttf \
"

do_install() {
    oe_runmake 'DESTDIR=${D}' PREFIX=${prefix} lv2dir=${libdir}/lv2 install

    install -d  ${D}${datadir}/pixmaps
    install -m 0644 ${S}/doc/setBfree.png ${D}${datadir}/pixmaps
    install -m 0644 ${S}/doc/x42-whirl.png ${D}${datadir}/pixmaps

    install -d  ${D}${datadir}/applications
    install -m 0644 ${WORKDIR}/setbfree.desktop ${D}${datadir}/applications
    install -m 0644 ${WORKDIR}/x42-whirl.desktop ${D}${datadir}/applications
}

FILES:${PN} += " \
    ${datadir}/setBfree \
    ${libdir}/lv2 \
"

RDEPENDS:${PN} += "ttf-bitstream-vera"

# TBD: proper fix for
# ERROR: setbfree-0.8.11-r0 do_package: QA Issue: File '/usr/lib/lv2/b_synth/b_synthUI.so' from setbfree was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
